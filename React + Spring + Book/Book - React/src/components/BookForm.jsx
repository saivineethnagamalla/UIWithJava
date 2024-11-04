import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';

function BookForm() {
    const { id } = useParams();
    const [book, setBook] = useState({
        title: '',
        author: '',
        description: '',
        imageUrl: ''
    });

    useEffect(() => {
        if (id) {
            // Fetch the book details if editing an existing book
            fetch(`http://localhost:8080/api/books/${id}`)
                .then(response => response.json())
                .then(data => setBook(data))
                .catch(error => console.error('There was an error!', error));
        }
    }, [id]);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setBook({ ...book, [name]: value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        const method = id ? 'PUT' : 'POST';
        const url = id
            ? `http://localhost:8080/api/books/${id}`
            : 'http://localhost:8080/api/books';

        fetch(url, {
            method: method,
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(book)
        })
            .then(response => response.json())
            .then(data => {
                console.log('Success:', data);
                // Redirect or update UI as needed
            })
            .catch(error => console.error('There was an error!', error));
    };

    return (
        <form onSubmit={handleSubmit}>
            <input type="text" name="title" value={book.title} onChange={handleChange} placeholder="Title" />
            <input type="text" name="author" value={book.author} onChange={handleChange} placeholder="Author" />
            <textarea name="description" value={book.description} onChange={handleChange} placeholder="Description"></textarea>
            <input type="text" name="imageUrl" value={book.imageUrl} onChange={handleChange} placeholder="Image URL" />
            <button type="submit">Save</button>
        </form>
    );
}

export default BookForm;

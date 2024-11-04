import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';

function BookDetail() {
    const { id } = useParams();
    const [book, setBook] = useState(null);

    useEffect(() => {
        fetch(`http://localhost:8080/api/books/${id}`)
            .then(response => response.json())
            .then(data => setBook(data))
            .catch(error => console.error('There was an error fetching the book!', error));
    }, [id]);

    if (!book) return <div>Loading...</div>;

    return (
        <div>
            <img src={book.imageUrl} alt={book.title} width="100" height="100" />
            <h1>{book.title}</h1>
            <p>{book.description}</p>
            <p>{book.author}</p>
        </div>
    );
}

export default BookDetail;

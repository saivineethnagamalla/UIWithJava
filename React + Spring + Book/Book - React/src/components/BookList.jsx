import React, { useState, useEffect } from 'react';

function BookList() {
    const [books, setBooks] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8080/api/books')
            .then(response => response.json())
            .then(data => setBooks(data))
            .catch(error => console.error('There was an error fetching the books!', error));
    }, []);

    return (
        <div>
            <h1>Book List </h1>
            <ul>
                {
                    books.map(book => (
                        <li key={book.id} > {book.title} : {book.id}: {book.author} </li>

                    ))
                }
            </ul>
        </div>
    );
}

export default BookList;
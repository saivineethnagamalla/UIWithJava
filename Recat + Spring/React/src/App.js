import React, { useState, useEffect } from 'react';

function App() {
  const [message, setMessage] = useState('');

  useEffect(() => {
    fetch('http://localhost:8080/v1/')
      .then(response => response.text())
      .then(data => setMessage(data))
      .catch(error => {
        console.error("there is a error", error);
      });

  }, []);


  return (
    <div className="App">
      <h1>{message} + react testing</h1>
    </div>
  );
}

export default App;

// 1. Import the express module
const express = require('express');

// 2. Create an Express app
const app = express();

// 3. Define a port to listen on
const PORT = 3000;

// 4. Define a basic route
app.get('/', (req, res) => {
  res.send('Hello, Node.js and Express!');
});

// 5. Start the server
app.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});

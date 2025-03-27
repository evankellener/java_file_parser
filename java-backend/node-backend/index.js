// 1. Import the express module
const express = require('express');
const fs = require('fs');
const path = require('path');

// 2. Create an Express app
const app = express();

// 3. Define a port to listen on
const PORT = 3000;

// 4. Define a basic route
app.get('/', (req, res) => {
  res.send('Hello, Node.js and Express!');
});

app.get('/api/parsed-class', (req, res) => {
  const filePath = path.join(__dirname, '../output/ParsedClass.json');

  fs.readFile(filePath, 'utf-8', (err, data) => {
    if (err){
      console.error("Error reading file:", err);
      return res.status(500).json({error:"Failed to readfile"});
    }
    const jsonData = JSON.parse(data);
    res.json(jsonData);
  });
});

// 5. Start the server
app.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});

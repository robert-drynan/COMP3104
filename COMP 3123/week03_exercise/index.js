const http = require("http");
const Employee = require("./Employee")
console.log("Lab 03 -  NodeJs");

//TODO - Fix any errors you found working with lab exercise

//Define Server Port
const port = process.env.PORT || 8081

//Create Web Server using CORE API
const server = http.createServer((req, res) => {
    if (req.method !== 'GET') {
        res.end(`{"error": "${http.STATUS_CODES[405]}"}`)
    } else {
        if (req.url === '/') {
            //TODO - Display message "<h1>Welcome to Lab Exercise 03</h1>"
            console.log("/")
            return res.end(Employee.getWelcomeMessage())
        }

        if (req.url === '/employee') {
            //TODO - Display all details for employees in JSON format
            console.log("/employee")
            return res.end(JSON.stringify(Employee.getAllEmployees()))
        }

        if (req.url === '/employee/names') {
            //TODO - Display only all employees {first name + lastname} in Ascending order in JSON Array
            //e.g. [ "Ash Lee", "Mac Mohan", "Pritesh Patel"]
            console.log("/employee/names")
            return res.end(JSON.stringify(Employee.getEmployeeNames()))
        }

        if (req.url === '/employee/totalsalary') {
            //TODO - Display Sum of all employees salary in given JSON format 
            //e.g. { "total_salary" : 100 }
            console.log("/employee/totalsalary")
            return res.end(JSON.stringify(Employee.getTotalSalary()))

    }
    res.end(`{"error": "${http.STATUS_CODES[404]}"}`)
    }
})

server.listen(port, () => {
    console.log(`Server listening on port ${port}`);
})
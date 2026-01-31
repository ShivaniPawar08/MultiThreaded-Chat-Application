# MultiThreaded-Chat-Application
Multi-Client Chat Application (Java Socket Programming)
Company: CODTECH IT SOLUTIONS
Name: Shivani Pawar
Intern ID: CTIS3902
Domain: Java Programming
Duration: 4 Weeks
Mentor: Neela Santosh

Project Description

The Multi-Client Chat Application is a Java-based networking project developed as part of my internship at CODTECH IT SOLUTIONS. This task focuses on implementing real-time communication between multiple users using TCP socket programming and Java’s input/output streams.

The main goal of this project is to understand how client–server architectures work in distributed systems. A centralized chat server manages incoming connections from multiple clients, while each connected client can send and receive messages simultaneously. The project makes extensive use of multithreading to ensure that communication remains smooth and responsive even when several users are active at the same time.

By developing this system without external libraries, the application demonstrates core networking fundamentals such as socket connections, port communication, concurrent programming, and message broadcasting mechanisms.

 What the Program Does

This chat system consists of two main components:

 Chat Server

Starts listening on port 5000.

Accepts multiple client connections.

Creates a new thread for every connected user.

Maintains a shared list of client output streams.

Broadcasts received messages to all connected clients.

Handles client disconnections gracefully.

 Chat Client

Connects to the server using localhost and port 5000.

Allows users to type messages from the console.

Runs a background thread to continuously listen for server messages.

Displays incoming messages in real time.

Sends user-entered messages to the server instantly.


Output:
<img width="1254" height="190" alt="image" src="https://github.com/user-attachments/assets/da9c807a-a916-40a0-8f79-e38a00f34f53" />
<img width="1176" height="326" alt="image" src="https://github.com/user-attachments/assets/98baed2f-08ab-4ff4-93da-949c1f40f7cb" />

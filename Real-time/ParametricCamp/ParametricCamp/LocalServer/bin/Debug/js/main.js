// Create WebSocket connection.
const socket = new WebSocket("ws://192.168.0.104:2910/EchoAll");

// Connection opened
socket.addEventListener("open", (event) => {
    socket.send("I'am 2910...");
});

// Listen for messages
socket.addEventListener("message", (event) => {
    console.log("Message from server: ", event.data);
});
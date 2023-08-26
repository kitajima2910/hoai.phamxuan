let canvas = document.getElementById("canvas");
let context = canvas.getContext("2d");

let window_height = window.innerHeight;
let window_width = window.innerWidth;

canvas.width = window_width;
canvas.height = window_height;

canvas.style.backgroundColor = "#ff8";


class Image {
    constructor(imagePath, xpos, ypos, width, height) {
        this.imagePath = imagePath;
        this.xpos = xpos;
        this.ypos = ypos;
        this.width = width;
        this.height = height;
    }
}

function createImage(context, imagePath, xpos, ypos, width, height) {
    let myImage = document.createElement("img");
    myImage.src = imagePath;
    myImage.onload = function() {
        context.drawImage(myImage, xpos, ypos, width, height);
    }
}

let image = new Image("./images/Banana.png", 100, 50, 200, 200);
createImage(context, image.imagePath, image.xpos, image.ypos, image.width, image.height);
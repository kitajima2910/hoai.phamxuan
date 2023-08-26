let canvas = document.getElementById("canvas");
let context = canvas.getContext("2d");

let window_height = window.innerHeight;
let window_width = window.innerWidth;

canvas.width = window_width;
canvas.height = window_height;

canvas.style.backgroundColor = "#ff8";

class Circle {

    constructor(xpos, ypos, radius, color, text, speed) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.radius = radius;
        this.color = color;
        this.text = text;
        this.speed = speed;

        this.dx = 1 * this.speed;
        this.dy = 1 * this.speed;
    }

    draw(context) {
        context.beginPath();

        context.strokeStyle = this.color;
        context.textAlign = "center";
        context.baseline = "middle";
        context.font = "20px Arial";
        context.fillText(this.text, this.xpos, this.ypos);
        // context.strokeText(this.text, this.xpos, this.ypos);

        context.lineWidth = 5;
        context.arc(this.xpos, this.ypos, this.radius, 0, Math.PI * 2, false);
        context.stroke();
        context.closePath();
    }

    update() {

        this.draw(context);

        if((this.xpos + this.radius) > window_width) {
            this.dx = -this.dx;
        }

        if((this.xpos - this.radius) < 0) {
            this.dx = -this.dx;
        }

        if((this.ypos + this.radius) > window_height) {
            this.dy = -this.dy;
        }

        if((this.ypos - this.radius) < 0) {
            this.dy = -this.dy;
        }

        this.xpos += this.dx;
        this.ypos += this.dy;
    }
}

let getDistance = function(xpos1, ypos1, xpos2, ypos2) {
    return Math.sqrt((xpos2 - xpos1) ** 2 + (ypos2 - ypos1) ** 2);
}

let all_circles = [];

let randomNumber = function(min, max) {
    return Math.random() * (max - min) + min;
}

for(let i = 0; i < 10; i++) {
    let radius = 50;
    let random_x = randomNumber(radius, window_width - radius);
    let random_y = randomNumber(radius, window_height - radius);

    let my_circle = new Circle(random_x, random_y, radius, "black", "A", 2);
    all_circles.push(my_circle);
}

let updateCircle = function() {
    context.clearRect(0, 0, window_width, window_height);
    
    all_circles.forEach((element) => {
        element.update();
    });

    // if(getDistance(my_circle1.xpos, my_circle1.ypos, my_circle2.xpos, my_circle2.ypos) < (my_circle2.radius + my_circle1.radius)) {
    //     my_circle2.color = "red";
    // } else {
    //     my_circle2.color = "black";
    // }

    requestAnimationFrame(updateCircle);
}

requestAnimationFrame(updateCircle);
// for(let number = 0; number < 1; number++) {
//     let random_x = Math.random() * window_width;
//     let random_y = Math.random() * window_height;

//     let my_circle = new Circle(random_x, random_y, 50, "black", circle_counter++, 1);
//     all_circles.push(my_circle);
//     createCircle(all_circles[number]);
// }

// console.log(all_circles);
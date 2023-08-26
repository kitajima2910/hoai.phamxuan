let canvas = document.getElementById("canvas");
let context = canvas.getContext("2d");

let window_height = window.innerHeight;
let window_width = window.innerWidth;

canvas.width = window_width;
canvas.height = window_height;

canvas.style.backgroundColor = "#ff8";

let hit_counter = 0;

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
        this.text = hit_counter;

        context.clearRect(0, 0, window_width, window_height);
        this.draw(context);

        if((this.xpos + this.radius) > window_width) {
            this.dx = -this.dx;
            hit_counter++;
        }

        if((this.xpos - this.radius) < 0) {
            this.dx = -this.dx;
            hit_counter++;
        }

        if((this.ypos + this.radius) > window_height) {
            this.dy = -this.dy;
            hit_counter++;
        }

        if((this.ypos - this.radius) < 0) {
            this.dy = -this.dy;
            hit_counter++;
        }

        this.xpos += this.dx;
        this.ypos += this.dy;
    }
}


let my_circle = new Circle(100, 100, 50, "black", hit_counter, 2);
my_circle.draw(context);

let updateCircle = function() {
    my_circle.update();
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
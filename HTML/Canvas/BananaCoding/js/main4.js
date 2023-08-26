let canvas = document.getElementById("canvas");
let context = canvas.getContext("2d");

let window_height = window.innerHeight;
let window_width = window.innerWidth;

canvas.width = window_width;
canvas.height = window_height;

canvas.style.backgroundColor = "#bbf";

class Circle {

    constructor(xpos, ypos, radius, color) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.radius = radius;
        this.color = color;
    }

    draw(context) {
        context.beginPath();
        context.arc(this.xpos, this.ypos, this.radius, 0, Math.PI * 2, false);
        context.strokeStyle = "grey";
        context.lineWidth = 3;
        context.fillStyle = this.color;
        context.fill();
        context.stroke();
        context.closePath();
    }

    changeColor(newColor) {
        this.color = newColor;
        this.draw(context);
    }

    clickCircle(xmouse, ymouse) {
        const distance = Math.sqrt((xmouse - this.xpos) ** 2 + (ymouse - this.ypos) ** 2);
        console.log(distance);
        if(distance < this.radius) {
            this.changeColor("#56f")
            return true;
        } 
        this.changeColor("#f56")
        return false;
    }
}

let circle = new Circle(200, 200, 100, "#f56");
circle.draw(context);

canvas.addEventListener("click", (event) => {
    const rect = canvas.getBoundingClientRect();
    const x = event.clientX - rect.left;
    const y = event.clientY - rect.top;
    console.log(circle.clickCircle(x, y));
});
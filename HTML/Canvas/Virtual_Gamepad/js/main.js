const utils = new Utils();

let canvas, context;

function createCanvas() {
    if (canvas === undefined) {
        canvas = document.createElement("canvas");
        canvas.setAttribute("id", "canvas");
        canvas.style.display = "block";
        document.body.appendChild(canvas);
        context = canvas.getContext("2d");
    }
}

function removeCanvas() {
    if (canvas !== undefined) {
        document.body.removeChild(canvas);
        canvas = undefined;
    }
}

// Declare variable
let resizeTimer;
let buttonA, buttonAPressed;
let buttonB, buttonBPressed;
let buttonX, buttonXPressed;
let buttonY, buttonYPressed;

function loadImages() {
    // Start: Button Action
    buttonA = new Image();
    buttonA.src = "./image/ButtonA.png";
    buttonAPressed = new Image();
    buttonAPressed.src = "./image/ButtonAPressed.png";

    buttonB = new Image();
    buttonB.src = "./image/ButtonB.png";
    buttonBPressed = new Image();
    buttonBPressed.src = "./image/ButtonBPressed.png";

    buttonX = new Image();
    buttonX.src = "./image/ButtonX.png";
    buttonXPressed = new Image();
    buttonXPressed.src = "./image/ButtonXPressed.png";

    buttonY = new Image();
    buttonY.src = "./image/ButtonY.png";
    buttonYPressed = new Image();
    buttonYPressed.src = "./image/ButtonYPressed.png";
    // End: Button Action
}

window.addEventListener("load", function () {
    if (utils.isPortrait()) {
        isPortrait = true;
        isLandscape = false;
    } else if (utils.isLandscape()) {
        isPortrait = false;
        isLandscape = true;
    }

    loadImages();
    init();

    setInterval(function () {
        if (!isLocked) {
            canvas.addEventListener("touchstart", function (e) {
                utils.lockFullscreen();
                context.font = "16px Georgia";
                context.fillText("avail: " + screen.availWidth + " x " + screen.availHeight + " - Lock: " + isLocked, 20, 20);
                context.fillText("wx   : " + window.innerWidth + " x " + window.innerHeight + " - Lock: " + isLocked, 20, 40);
                context.fillText("Portrait: " + isPortrait + " - Landscape: " + isLandscape, 20, 60);
                context.fillText(navigator.userAgent, 20, 80);
            }, false);
        }
    }, 100);

    setInterval(function () {
        if (document.fullscreenElement === null) {
            isLocked = false;
        } else {
            isLocked = true;
        }
        context.font = "16px Georgia";
        context.fillText("avail: " + screen.availWidth + " x " + screen.availHeight + " - Lock: " + isLocked, 20, 20);
        context.fillText("wx   : " + window.innerWidth + " x " + window.innerHeight + " - Lock: " + isLocked, 20, 40);
        context.fillText("Portrait: " + isPortrait + " - Landscape: " + isLandscape, 20, 60);
        context.fillText(navigator.userAgent, 20, 80);
    }, 100);

    setTimeout(drawCanvas, 250);

}, false);

window.addEventListener("resize", function () {
    init();
    setTimeout(drawCanvas, 250);
}, false);

window.addEventListener("orientationchange", function () {
    if (utils.isPortrait()) {
        isPortrait = true;
        isLandscape = false;
    } else if (utils.isLandscape()) {
        isPortrait = false;
        isLandscape = true;
    }
    init();
    setTimeout(drawCanvas, 250);
}, false);

function init() {
    removeCanvas();
    createCanvas();
    canvas.style.backgroundColor = "aquamarine";
    if (!isLocked || screen.availWidth > screen.availHeight) {
        canvas.width = window.innerWidth;
        canvas.height = window.innerHeight;
    } else if (isLocked && screen.availWidth < screen.availHeight) {
        canvas.width = screen.availWidth;
        canvas.height = screen.availHeight;
    }
}

function drawCanvas() {
    if (utils.isPortrait()) {
        isPortrait = true;
        isLandscape = false;
        drawActionPortrait();
    } else if (utils.isLandscape()) {
        isPortrait = false;
        isLandscape = true;
        drawActionLandscape();
    }
}

// Start: Button Action
function drawActionLandscape() {
    const RADIUS = 25;
    
    // Start: Button A
    const cricleA = new Circle(canvas.width - RADIUS * 4, canvas.height - RADIUS * 2, RADIUS, "#00A17B");
    cricleA.draw()
        .imageObject(buttonA, "./image/ButtonA.png")
        .action("Button A", buttonAPressed, "./image/ButtonAPressed.png");
    // End: Button A

    // Start: Button B
    const cricleB = new Circle(canvas.width - RADIUS * 2, canvas.height - RADIUS * 4, RADIUS, "#00A17B");
    cricleB.draw()
        .imageObject(buttonB, "./image/ButtonB.png")
        .action("Button B", buttonBPressed, "./image/ButtonBPressed.png");
    // End: Button B

    // Start: Button X
    const cricleX = new Circle(canvas.width - RADIUS * 6, canvas.height - RADIUS * 4, RADIUS, "#00A17B");
    cricleX.draw()
        .imageObject(buttonX, "./image/ButtonX.png")
        .action("Button X", buttonXPressed, "./image/ButtonXPressed.png");
    // End: Button X

    // Start: Button Y
    const cricleY = new Circle(canvas.width - RADIUS * 4, canvas.height - RADIUS * 6, RADIUS, "#00A17B");
    cricleY.draw()
        .imageObject(buttonY, "./image/ButtonY.png")
        .action("Button Y", buttonYPressed, "./image/ButtonYPressed.png");
    // End: Button Y
}

function drawActionPortrait() {
    const RADIUS = 25;

    // Start: Button A
    const cricleA = new Circle(RADIUS * 2, canvas.height - RADIUS * 4, RADIUS, "#00A17B");
    cricleA.draw()
        .imageObject(buttonA, "./image/ButtonA.png", { flag: true, x: 0, y: -(RADIUS * 2), deg: 90 })
        .action("Button A", buttonAPressed, "./image/ButtonAPressed.png");
    // End: Button A

    // Start: Button B
    const cricleB = new Circle(RADIUS * 4, canvas.height - RADIUS * 2, RADIUS, "#00A17B");
    cricleB.draw()
        .imageObject(buttonB, "./image/ButtonB.png", { flag: true, x: 0, y: -(RADIUS * 2), deg: 90 })
        .action("Button B", buttonBPressed, "./image/ButtonBPressed.png");
    // End: Button B

    // Start: Button X
    const cricleX = new Circle(RADIUS * 4, canvas.height - RADIUS * 6, RADIUS, "#00A17B");
    cricleX.draw()
        .imageObject(buttonX, "./image/ButtonX.png", { flag: true, x: 0, y: -(RADIUS * 2), deg: 90 })
        .action("Button X", buttonXPressed, "./image/ButtonXPressed.png");
    // End: Button X

    // Start: Button Y
    const cricleY = new Circle(RADIUS * 6, canvas.height - RADIUS * 4, RADIUS, "#00A17B");
    cricleY.draw()
        .imageObject(buttonY, "./image/ButtonY.png", { flag: true, x: 0, y: -(RADIUS * 2), deg: 90 })
        .action("Button Y", buttonYPressed, "./image/ButtonYPressed.png");
    // End: Button Y
}
// End: Button Action

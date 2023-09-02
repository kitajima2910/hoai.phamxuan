class Circle {

    constructor(xPos, yPos, radius, color) {
        this.xPos = xPos;
        this.yPos = yPos;
        if (document.fullscreenElement !== null && isPortrait) {
            this.yPos = yPos - radius
        }
        this.radius = radius;
        this.color = color;
    }

    draw() {
        context.beginPath();
        context.arc(this.xPos, this.yPos, this.radius, 0, Math.PI * 2, false);
        context.strokeStyle = this.color;
        context.stroke();
        context.closePath();
        return this;
    }

    image(imgPath) {
        this.imgPath = imgPath;

        const xPosImg = this.xPos - this.radius;
        const yPosImg = this.yPos - this.radius;
        const wImg = this.radius * 2;
        const hImg = this.radius * 2;

        const base_image = new ImageV2(imgPath, xPosImg, yPosImg, wImg, hImg);
        base_image.create();

        return this;
    }

    imageObject(imgObj, imgPath, isRotate = { flag: false, x: 0, y: 0, deg: 90 }) {
        this.imgObj = imgObj;
        this.imgPath = imgPath;
        this.isRotate = isRotate;

        const xPosImg = this.xPos - this.radius;
        const yPosImg = this.yPos - this.radius;
        const wImg = this.radius * 2;
        const hImg = this.radius * 2;

        const base_image = new ImageV2(imgPath, xPosImg, yPosImg, wImg, hImg);
        base_image.createCombine(imgObj, imgPath, isRotate);

        return this;
    }

    action(name, imgObj, imgPath) {
        const xPosImg = this.xPos - this.radius;
        const yPosImg = this.yPos - this.radius;
        const wImg = this.radius * 2;
        const hImg = this.radius * 2;

        const imgObjPressed = imgObj;
        const imgPathPressed = imgPath;
        const imgObjReleased = this.imgObj;
        const imgPathReleased = this.imgPath;

        const isRotate = this.isRotate;

        const xClick = this.xPos;
        const yClick = this.yPos;
        const radiusClick = this.radius;

        // Desktop: TEST CLICK
        canvas.addEventListener("mousedown", function (e) { pressed(e); }, false);
        canvas.addEventListener("mouseup", function (e) { released(e); }, false);
        canvas.addEventListener("mousemove", function (e) { releasedOutOfScope(e); }, false);

        // Mobile
        canvas.addEventListener("touchstart", function (e) { pressed(e); }, false);
        canvas.addEventListener("touchend", function (e) { released(e); }, false);
        canvas.addEventListener("touchmove", function (e) { releasedOutOfScope(e); }, false);

        const pressed = function (e) {
            e.preventDefault();

            let x, y;

            try {
                x = e.changedTouches[0].pageX - canvas.getBoundingClientRect().left;
                y = e.changedTouches[0].pageY - canvas.getBoundingClientRect().top;
            } catch (error) {
                x = e.pageX - canvas.getBoundingClientRect().left;
                y = e.pageY - canvas.getBoundingClientRect().top;
            }

            if ((x >= xClick - radiusClick && x <= xClick + radiusClick) &&
                (y >= yClick - radiusClick && y <= yClick + radiusClick)) {
                console.log(name + " is pressed");
                const base_image = new ImageV2(imgPathPressed, xPosImg, yPosImg, wImg, hImg);
                base_image.createCombine(imgObjPressed, imgPathPressed, isRotate);
            }
        }

        const released = function (e) {
            e.preventDefault();

            let x, y;

            try {
                x = e.changedTouches[0].pageX - canvas.getBoundingClientRect().left;
                y = e.changedTouches[0].pageY - canvas.getBoundingClientRect().top;
            } catch (error) {
                x = e.pageX - canvas.getBoundingClientRect().left;
                y = e.pageY - canvas.getBoundingClientRect().top;
            }

            if ((x >= xClick - radiusClick && x <= xClick + radiusClick) &&
                (y >= yClick - radiusClick && y <= yClick + radiusClick)) {
                console.log(name + " is released");
                const base_image = new ImageV2(imgPathReleased, xPosImg, yPosImg, wImg, hImg);
                base_image.createCombine(imgObjReleased, imgPathReleased, isRotate);
            }
        }

        const releasedOutOfScope = function (e) {
            e.preventDefault();

            let x, y;

            try {
                x = e.changedTouches[0].pageX - canvas.getBoundingClientRect().left;
                y = e.changedTouches[0].pageY - canvas.getBoundingClientRect().top;
            } catch (error) {
                x = e.pageX - canvas.getBoundingClientRect().left;
                y = e.pageY - canvas.getBoundingClientRect().top;
            }

            if (!((x >= xClick - radiusClick && x <= xClick + radiusClick) &&
                (y >= yClick - radiusClick && y <= yClick + radiusClick))) {
                // console.log(name + " is released");
                const base_image = new ImageV2(imgPathReleased, xPosImg, yPosImg, wImg, hImg);
                base_image.createCombine(imgObjReleased, imgPathReleased, isRotate);
            }
        }
    }
}
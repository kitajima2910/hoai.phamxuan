class ImageV2 {

    constructor(imgPath, xPos, yPos, width, height) {
        this.imgPath = imgPath;
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
    }

    create() {
        const xPosImg = this.xPos;
        const yPosImg = this.yPos;
        const wImg = this.width;
        const hImg = this.height;

        const image = new Image();
        image.src = this.imgPath;
        image.onload = function () {
            context.drawImage(image, xPosImg, yPosImg, wImg, hImg);
        }
    }

    create(imgPath) {
        this.imgPath = imgPath;

        const xPosImg = this.xPos;
        const yPosImg = this.yPos;
        const wImg = this.width;
        const hImg = this.height;

        const image = new Image();
        image.src = imgPath;
        image.onload = function () {
            context.drawImage(image, xPosImg, yPosImg, wImg, hImg);
        }
    }

    createRotate(imgPath, isRotate = { flag: false, x: 0, y: 0, deg: 90 }) {
        this.imgPath = imgPath;

        const xPosImg = this.xPos;
        const yPosImg = this.yPos;
        const wImg = this.width;
        const hImg = this.height;

        const image = new Image();
        image.src = imgPath;
        image.onload = function () {
            context.save();
            context.translate(xPosImg, yPosImg);
            context.rotate(isRotate.deg * Math.PI / 180);
            context.drawImage(image, isRotate.x, isRotate.y, wImg, hImg);
            context.restore();
        }
    }

    createObject(imgObj) {
        const xPosImg = this.xPos;
        const yPosImg = this.yPos;
        const wImg = this.width;
        const hImg = this.height;

        context.drawImage(imgObj, xPosImg, yPosImg, wImg, hImg);
    }

    createObjectRotate(imgObj, isRotate = { flag: false, x: 0, y: 0, deg: 90 }) {
        const xPosImg = this.xPos;
        const yPosImg = this.yPos;
        const wImg = this.width;
        const hImg = this.height;

        
        context.save();
        context.translate(xPosImg, yPosImg);
        context.rotate(isRotate.deg * Math.PI / 180);
        context.drawImage(imgObj, isRotate.x, isRotate.y, wImg, hImg);
        context.restore();
    }

    createCombine(imgObj, imgPath, isRotate = { flag: false, x: 0, y: 0, deg: 90 }) {
        this.imgPath = imgPath;

        if (imgObj instanceof HTMLImageElement) {
            if (imgObj.complete) {
                if(isRotate.flag) {
                    this.createObjectRotate(imgObj, isRotate);
                } else {
                    this.createObject(imgObj);
                }
            } else {
                if(isRotate.flag) {
                    this.createRotate(imgPath, isRotate);
                } else {
                    this.create(imgPath);
                }
            }
        }
    }

}
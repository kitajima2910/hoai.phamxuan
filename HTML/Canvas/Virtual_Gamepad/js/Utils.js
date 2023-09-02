let isLocked = false;
let isLandscape = false;
let isPortrait = false;

class Utils {

    constructor() {

    }

    browserDetect() {
        let userAgent = navigator.userAgent;
        if (userAgent.match(/opr\//i)) {
            return "Opera";
        } else if (userAgent.match(/chrome|chromium|crios/i)) {
            return "Chrome";
        } else if (userAgent.match(/firefox|fxios/i)) {
            return "Firefox";
        } else if (userAgent.match(/safari/i)) {
            return "Safari";
        } else if (userAgent.match(/edg/i)) {
            return "Edge";
        } else {
            return "No browser detection";
        }
    }

    getOperatingSystem() {
        var userAgent = navigator.userAgent || navigator.vendor || window.opera;
        if (/android/i.test(userAgent))
            return "Android";
        if (/iPhone/.test(userAgent) && !window.MSStream)
            return "iPhone";
        if (/iPad/.test(userAgent) && !window.MSStream)
            return "iPad";
        return "unknown";
    }

    isLandscape() {
        return screen.availWidth > screen.availHeight;
    }

    isPortrait() {
        return screen.availWidth < screen.availHeight;
    }

    /* View in fullscreen */
    openFullscreen(element) {
        if (element.requestFullscreen) { /* Chrome */
            element.requestFullscreen();
        } else if (element.webkitRequestFullscreen) { /* Safari */
            element.webkitRequestFullscreen();
        } else if (element.msRequestFullscreen) { /* IE11 */
            element.msRequestFullscreen();
        }
    }

    /* Close fullscreen */
    closeFullscreen() {
        if (document.exitFullscreen) { /* Chrome */
            document.exitFullscreen();
        } else if (document.webkitExitFullscreen) { /* Safari */
            document.webkitExitFullscreen();
        } else if (document.msExitFullscreen) { /* IE11 */
            document.msExitFullscreen();
        }
    }

    /* View in lock fullscreen */
    lockFullscreen() {
        if (document.documentElement.requestFullscreen) { /* Chrome */
            document.documentElement.requestFullscreen();
        } else if (document.documentElement.webkitRequestFullscreen) { /* Safari */
            document.documentElement.webkitRequestFullscreen();
        } else if (element.msRequestFullscreen) { /* IE11 */
            document.documentElement.msRequestFullscreen();
        }

        if ((screen.availWidth > screen.availHeight) && (window.screen.orientation.type == "landscape-primary")) {
            window.screen.orientation.lock("landscape-primary");
        } else if ((screen.availWidth < screen.availHeight) && (window.screen.orientation.type == "portrait-primary")) {
            window.screen.orientation.lock("portrait-primary");
        }
    }
}
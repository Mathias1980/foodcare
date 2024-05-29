'use strict';

    const foodinit = () => {
        setNavbarActive();      
    }
    
    const setNavbarActive = () => {
        let current = window.location.href.substring( window.location.href.indexOf("8080") + 4 );
        let navbar = Array.from(document.querySelectorAll("ul.topnav-links > li"));
        navbar.forEach( (el) => {
            (el.firstChild.href.substring( el.firstChild.href.indexOf("8080") + 4 ) === current) ? el.firstChild.classList.add('active') : el.firstChild.classList.remove('active');
        })
    }
    
    foodinit();

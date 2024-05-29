'use strict';    
    
    const createDOM = (inhalt, typ, eltern, klasse, id, src) => {
        let neu = document.createElement(typ);
        if (inhalt) neu.innerHTML = inhalt;
        if (klasse) neu.className = klasse;
        if (id) neu.id = id;
        if (src) neu.src = src;
        eltern.append(neu);

        return neu;
    }
    
    const dom = {

        create({
            inhalt = '',
            typ = 'div',
            eltern = false,
            klassen = [],
            attr = {},
            listeners = {},
            styles = {},
            amEnde = true,
            id = false
        } = {}) {
            let neu = document.createElement(typ);
            if (inhalt) neu.innerHTML = inhalt;
            if (id) neu.id = id;
            if (klassen.length) neu.className = klassen.join(' ');

            Object.entries(attr).forEach(el => neu.setAttribute(...el));
            Object.entries(listeners).forEach(el => neu.addEventListener(...el));
            Object.entries(styles).forEach(style => neu.style[style[0]] = style[1]);

            if (eltern) {
                if (!amEnde && eltern.children.length) eltern.prepend(neu);
                else eltern.append(neu);
            }

            return neu;
        },
        $(sel){
            return document.querySelector(sel);
        },
        $$(sel){
            return Array.from(document.querySelectorAll(sel));
        }
    }

    const calculatePercentage = (value, total) => (value / total) * 100; 
    
    const findMaxID = childNodes => {
        if(childNodes.length > 1){
            let max = 1;
            //Array.from(childNodes).forEach(el => console.log(el.attributes.length + ' ' + el.attributes));
            Array.from(childNodes)                           
                .filter(el => el.attributes.length > 1)
                .forEach( el => {
                    if(parseInt(el.dataset.id) > max){ 
                        max = parseInt(el.dataset.id); 
                    }
            });
            return max + 1;
        }else{
            return 1;
        }
    }

    const findElementMaxId = listItems => {
        let elementMitHoechsterId = null;
        let hoechsteId = 0;

        listItems.forEach(li => {
            const aktuelleId = parseInt(li.getAttribute('data-id'), 10);
            if (aktuelleId > hoechsteId) {
              hoechsteId = aktuelleId;
              elementMitHoechsterId = li;
            }
        });
        return elementMitHoechsterId;    
    }
    
    
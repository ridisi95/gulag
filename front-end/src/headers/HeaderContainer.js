import React from 'react';
import HeaderContent from "./HeaderContent";

const HeaderContainer = () => {
    const onOpenBurger = () => {
        let menu__burger = document.querySelector('#menu__burger');
        let header__menu = document.querySelector('#header__menu');
        menu__burger.classList.toggle("active");
        header__menu.classList.toggle("active");
    }
    return (
        <div className="header__container">
            <div onClick={onOpenBurger} className="menu__burger burger" id="menu__burger">
                <span className="span__up"/>
                <span className="span__middle"/>
                <span className="span__down"/>
            </div>
            <HeaderContent/>
        </div>
    )
}
export default HeaderContainer;
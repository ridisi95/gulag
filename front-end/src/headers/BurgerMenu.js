import React from 'react';
import {useDispatch} from "react-redux";
import {makeOpenHeaderBurger} from "./redux/header-actions";
import OutsideClickHandler from "react-outside-click-handler";
import HeaderContent from "./HeaderContent";

const BurgerMenu = ({isOpenBurgerMenu = false}) => {
    const dispatch = useDispatch();
    const onOpenBurgerMenu = (isOpenBurgerMenu) => {
        dispatch(makeOpenHeaderBurger(isOpenBurgerMenu));
        document
            .querySelector('#menu__burger')
            .classList.toggle("active", isOpenBurgerMenu);
        document
            .querySelector('#header__menu')
            .classList.toggle("active", isOpenBurgerMenu);
    }
    return (
        <OutsideClickHandler onOutsideClick = {() => onOpenBurgerMenu(false)}>
            <div onClick={() => onOpenBurgerMenu(isOpenBurgerMenu)} className="menu__burger burger" id="menu__burger">
                <span className="span__up"/>
                <span className="span__middle"/>
                <span className="span__down"/>
            </div>
            <HeaderContent/>
        </OutsideClickHandler>
    )
}
export default BurgerMenu;
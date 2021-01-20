import React from 'react';
import {useSelector} from "react-redux";
import BurgerMenu from "./BurgerMenu";

const HeaderContainer = () => {
    const isBurgerMenuOpen = useSelector(state => state.header.isBurgerMenuOpen);
    return (
        <div className="header__container">
            <BurgerMenu isOpenBurgerMenu={!isBurgerMenuOpen}/>
        </div>
    )
}
export default HeaderContainer;
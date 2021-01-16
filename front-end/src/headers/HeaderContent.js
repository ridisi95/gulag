import React from 'react';
import { useHistory } from "react-router";
import {Link} from "react-router-dom";

const HeaderContent = () => {
    const history = useHistory();
    const onOpenSearch = () => {
        let search__icon = document.querySelector('#search__icon');
        let header__form = document.querySelector('#header__form');
        let header__search = document.querySelector('#header__search');
        search__icon.classList.add("active");
        header__form.classList.add("active");
        header__search.classList.add("active");
    }
    return (
        <div className="header__content">
            <div className="header__logo logo">
                <Link to={'/'} onClick={() => history.push('/')}>GULAG</Link>
            </div>
            <div className="header__menu" id="header__menu">
                <div className="header__client">
                    <Link to="#" onClick={''} className="download__client">Скачать клиент</Link>
                </div>
                <div onClick={onOpenSearch} className="header__search" id="header__search">
                    <svg className="search__icon" id="search__icon">
                        <use xlinkHref="#search"/>
                    </svg>
                    <form className="header__form" action="#" id="header__form">
                        <input type="text" placeholder="Search"/>
                    </form>
                </div>
                <div className="header__register">
                    <button disabled={true} className="btn__register">
                        ЗАРЕГИСТРИРОВАТЬСЯ
                    </button>
                </div>
                <div className="header__login">
                    <button disabled={true} className="btn__login">
                        ВОЙТИ
                    </button>
                </div>
            </div>
        </div>
    )
}
export default HeaderContent;
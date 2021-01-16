import React from 'react';

const HeaderContent = () => {
    onclick = () => {
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
                <a href="#">GULAG</a>
            </div>
            <div className="header__menu" id="header__menu">
                <div className="header__client">
                    <a className="download__client" href="#">Скачать клиент</a>
                </div>
                <div onClick={onclick} className="header__search" id="header__search">
                    <svg className="search__icon" id="search__icon"/>
                    <form className="header__form" action="#" id="header__form">
                        <input type="text" placeholder="Search"/>
                    </form>
                </div>
                <div className="header__register">
                    <button className="btn__register">
                        ЗАРЕГИСТРИРОВАТЬСЯ
                    </button>
                </div>
                <div className="header__login">
                    <button className="btn__login">
                        ВОЙТИ
                    </button>
                </div>
            </div>
        </div>
    )
}
export default HeaderContent;
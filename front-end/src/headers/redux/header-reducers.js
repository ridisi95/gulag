import {A} from './header-actions'

const default_header_state = {
    openBurgerMenu: false
}

export const openBurgerMenuReducer = (current_state = {}, action = {}) => {
    return Object.assign({}, current_state, {...current_state.openBurgerMenu, ...action.isOpen});
}
export const header = (current_state = default_header_state, action = {}) => {
    switch (action.type) {
        case A.OPEN_BURGER:
            return openBurgerMenuReducer(current_state, action);
        default: return current_state;
    }
}
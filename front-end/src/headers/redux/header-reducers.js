import {A} from './header-actions'

const default_header_state = {
    isBurgerMenuOpen: false
}

export const openBurgerMenuReducer = (current_state = {}, action = {}) => {
    return {
        ...current_state,
        isBurgerMenuOpen: action.isOpen
    }
}
export const header = (current_state = default_header_state, action = {}) => {
    switch (action.type) {
        case A.OPEN_BURGER:
            return openBurgerMenuReducer(current_state, action);
        default: return current_state;
    }
}
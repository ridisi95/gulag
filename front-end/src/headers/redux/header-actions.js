//Action constants
export const A = {
    OPEN_BURGER: 'OPEN_BURGER'
}

//Action Creators
export const makeOpenHeaderBurger = (isOpen = false) => {
    return {
        type: A.OPEN_BURGER,
        isOpen
    }
}
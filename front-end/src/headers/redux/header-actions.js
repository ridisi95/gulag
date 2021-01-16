//Action constants
export const A = {
    OPEN_BURGER: 'OPEN_BURGER',
    CLOSE_BURGER: 'CLOSE_BURGER'
}

//Action Creators
export const makeOpenHeaderBurger = (isOpen) => {
    return {
        type: A.OPEN_BURGER,
        isOpen
    }
}

export const makeCloseHeaderBurger = (isOpen) =>  {
    return {
        type: A.CLOSE_BURGER,
        isOpen
    }
}
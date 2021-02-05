import styled from 'styled-components';

export const SliderWrapper = styled.div`
  max-width: 100%;

  .slick-slider {
    position: relative;

    display: block;
    box-sizing: border-box;

    user-select: none;
    touch-action: pan-y;

    -webkit-tap-highlight-color: transparent;
  }

  .slick-list {
    position: relative;

    display: block;
    overflow: hidden;

    margin: 0;
    padding: 0;
  }
  .slick-list:focus {
    outline: none;
  }
  .slick-list.dragging {
    cursor: hand;
  }

  .slick-slider .slick-track,
  .slick-slider .slick-list {
    transform: translate3d(0, 0, 0);
  }

  .slick-track {
    position: relative;
    top: 0;
    left: 0;

    display: block;
    margin: 0 auto;
  }
  .slick-track::before,
  .slick-track::after {
    display: table;

    content: '';
  }
  .slick-track::after {
    clear: both;
  }
  .slick-loading .slick-track {
    visibility: hidden;
  }

  .slick-slide {
    display: none;
    float: left;

    height: 100%;
    min-height: 0.625rem;
  }
  [dir='rtl'] .slick-slide {
    float: right;
  }
  .slick-slide img {
    display: block;
  }
  .slick-slide.slick-loading img {
    display: none;
  }
  .slick-slide.dragging img {
    pointer-events: none;
  }
  .slick-initialized .slick-slide {
    display: block;
  }
  .slick-loading .slick-slide {
    visibility: hidden;
  }
  .slick-vertical .slick-slide {
    display: block;

    height: auto;

    border: 0.625rem solid transparent;
  }
  .slick-arrow.slick-hidden {
    display: none;
  }

  .slick-dots {
    position: absolute;
    bottom: 15px;
    width: 100%;
    padding: 0;
    margin: 0;
    display: flex !important; // styles from library
    list-style: none;
    flex-direction: row;
    justify-content: center;
    margin-top: 1.125rem;
  }

  .slick-dots li {
    background: ${props => props.theme.colors.muted};
    width: 0.625rem;
    height: 0.625rem;
    border-radius: 50%;
    margin: 0.3125rem;
    position: relative;
  }

  .slick-dots li.slick-active {
    background: ${props => props.theme.colors.warning};
  }

  .slick-dots li button {
    font-size: 0;
    position: absolute;
    border: none;
    width: 100%;
    height: 100%;
    opacity: 0;
    cursor: pointer;
  }
`;

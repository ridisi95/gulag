import styled, { css } from 'styled-components';
import { devices } from 'src/config/styles/breakpoints/indes';

interface ArrowProps {
  arrowType: 'prev' | 'next';
}

export const Arrow = styled.button<ArrowProps>`
  &.slick-arrow {
    cursor: pointer;
    color: transparent;
    outline: none;
    text-shadow: none;
    appearance: none;
    background: transparent;
    border: 0;
    border-radius: 0;
    box-shadow: none;
    outline: 0;
    position: absolute;
    top: 50%;
    transform: translateY(-50%);
    width: 60px;
    height: 60px;
    z-index: 100;
  }

  & {
    ${({ arrowType }) =>
      arrowType === 'prev'
        ? css`
            left: 15px;
            :after {
              left: 0;
              transform: rotate(135deg);
            }
          `
        : css`
            right: 15px;
            :after {
              right: 0;
              transform: rotate(-45deg);
            }
          `}
    :after {
      border-color: ${props => props.theme.colors.white};
      content: '';
      border-style: solid;
      border-image: initial;
      border-width: 0 2px 2px 0;
      position: absolute;
      width: 10px;
      height: 10px;

      @media ${devices.tabletPortrait} {
        width: 12px;
        height: 12px;
      }

      @media ${devices.laptop} {
        width: 16px;
        height: 16px;
      }
    }
  }
`;

import React, { useEffect, useState } from 'react';
import { SliderWrapper } from 'components/Slider/style';
import dynamic from 'next/dynamic';
import { Settings } from 'react-slick';
import { NoSSR } from 'src/wrappers/NoSSR';

const Slider = dynamic(() => import('react-slick'), { ssr: false });

export type GulagSliderProps = Settings;

export const GulagSlider: React.FC<GulagSliderProps> = () => {
  const settings = {
    dots: true,
    infinite: true,
    speed: 500,
    slidesToShow: 1,
    slidesToScroll: 1,
  };
  const [isServer, setServer] = useState(true);

  useEffect(() => setServer(false), []);

  return (
    <NoSSR>
      <SliderWrapper>
        <Slider {...settings}>
          <h3>1</h3>
          <h3>2</h3>
        </Slider>
      </SliderWrapper>
    </NoSSR>
  );
};

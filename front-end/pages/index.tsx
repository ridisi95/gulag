import React, { ReactElement } from 'react';
import Image from 'next/image';
import { GulagSlider } from 'components/Slider';
import { HomeSliderWrapper, SliderImageWrapper } from 'src/styles/pages';

export default function Home(): ReactElement {
  return (
    <HomeSliderWrapper>
      <GulagSlider>
        <SliderImageWrapper>
          <Image
            width={960}
            height={540}
            layout="responsive"
            src="/images/fight-watch.jpg"
          />
        </SliderImageWrapper>
        <SliderImageWrapper>
          <Image
            width={960}
            height={540}
            layout="responsive"
            src="/images/helicopter-fight.jpg"
          />
        </SliderImageWrapper>
      </GulagSlider>
    </HomeSliderWrapper>
  );
}

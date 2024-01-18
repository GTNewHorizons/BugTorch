package jss.bugtorch.util;


import net.minecraft.client.audio.ISound;
import net.minecraft.util.ResourceLocation;

public  class JCSoundWarper implements ISound {

        ResourceLocation positionedSoundLocation;
        public AttenuationType attenuationType;

        public float XPosF;
        public float YPosF;
        public float ZPosF;



        public float volume;
        public  float pitch;

        public  boolean canRepeat;
        public  int repeatDelay;


        public JCSoundWarper(ISound esound){

            positionedSoundLocation =esound.getPositionedSoundLocation();
            attenuationType = esound.getAttenuationType();
            XPosF = esound.getXPosF();
            YPosF = esound.getYPosF();
            ZPosF = esound.getZPosF();

            volume = esound.getVolume();
            pitch = esound.getPitch();
            canRepeat = esound.canRepeat();
            repeatDelay = esound.getRepeatDelay();

        }


        @Override
        public ResourceLocation getPositionedSoundLocation() {
            return positionedSoundLocation;
        }

        @Override
        public boolean canRepeat() {

            return canRepeat;
        }

        @Override
        public int getRepeatDelay() {

            return repeatDelay;
        }

        @Override
        public float getVolume() {

            return volume;
        }

        @Override
        public float getPitch() {

            return pitch;
        }

        @Override
        public float getXPosF() {

            return XPosF;
        }

        @Override
        public float getYPosF() {

            return YPosF;
        }

        @Override
        public float getZPosF() {

            return ZPosF;
        }

        @Override
        public AttenuationType getAttenuationType() {
            return attenuationType;
        }


        public void setResLock(String soundLocation){
            positionedSoundLocation = new ResourceLocation(soundLocation);
        }

    }

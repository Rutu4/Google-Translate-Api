package com.upgrad.googleTranslateAPI.Find;




import com.upgrad.googleTranslateAPI.Translate.Language;


    public class FindResults{

        private Language language;
        private boolean reliable;
        private double confidence;

        public FindResults(final Language language, final boolean reliable, final double confidence) {
            this.language = language;
            this.reliable = reliable;
            this.confidence = confidence;
        }

        public Language getLanguage() {
            return language;
        }
        public void setLanguage(Language language) {
            this.language = language;
        }
        public boolean isReliable() {
            return reliable;
        }
        public void setReliable(boolean reliable) {
            this.reliable = reliable;
        }
        public double getConfidence() {
            return confidence;
        }
        public void setConfidence(double confidence) {
            this.confidence = confidence;
        }
    }
}

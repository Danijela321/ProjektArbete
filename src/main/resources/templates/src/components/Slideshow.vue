<template>
  <div id="slideshow">
    <div class="slideshow-container">
      <div class="slide">
        <img class="slide-img" src="../assets/images/car1.jpg" alt="test" />

        <div class="block">
          <span>This is a car</span>
        </div>
      </div>
      <div class="slide">
        <img class="slide-img" src="../assets/images/car2.jpg" alt="test" />
        <div class="block">
          <span>This is a car</span>
        </div>
      </div>
      <div class="slide">
        <img class="slide-img" src="../assets/images/car3.jpg" alt="test" />
        <div class="block">
          <span>This is a car</span>
        </div>
      </div>
      <button class="btn-prev fa fa-angle-left fa-2x" @click="plusSlides(-1)" />
      <button class="btn-next fa fa-angle-right fa-2x" @click="plusSlides(1)" />
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      slideIndex: 1,
      images: [""],
    };
  },

  methods: {
    slideImage() {},

    getSlides() {},

    plusSlides: function (n) {
      this.showSlides((this.slideIndex += n));
    },

    currentSlide: function (n) {
      this.showSlides((this.slideIndex = n));
    },

    showSlides: function (n) {
      var i;
      var slides = document.getElementsByClassName("slide");
      if (n > slides.length) {
        this.slideIndex = 1;
      }
      if (n < 1) {
        this.slideIndex = slides.length;
      }
      for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
      }
      slides[this.slideIndex - 1].style.display = "block";
    },
  },

  created: function () {},
};
</script>

<template>
  <div id="slideshow">
    <div class="slideshow-container">
      <div class="slide">
        <img class="slide-img" src="../assets/images/car2.jpg" alt="test" />
        <button class="btn-prev fa fa-angle-left fa-2x" />
        <button class="btn-next fa fa-angle-right fa-2x" />
        <div class="block">
          <span>This is a car</span>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      slideIndex: 0,
      images: [""],
    };
  },

  methods: {
    slideImage() {},

    getSlides() {},
  },

  created: function () {},
};
</script>

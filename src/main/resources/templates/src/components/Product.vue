<template>
  <div class="product">
    <div class="img-wrapper">
      <div class="img-container">
        <img src="../assets/images/car1.jpg" :alt="name" />
      </div>
    </div>
    <div class="product-info">
      <h2>{{ name }}</h2>
      <hr />
      <span>{{ model }} </span>
      <span>{{ brand }}</span>
      <br />
      <span>{{ price }} kr</span><br />
    </div>
  </div>
</template>
<script>
//import car from "./services/car.js";
export default {
  data() {
    return {
      name: "Namn",
      model: "Model",
      brand: "Märke",
      price: 1000,
      url: "",
    };
  },

  props: {
    source: {
      type: String,
      default: "car1.jpg",
    },
  },

  components: {},

  methods: {},

  created: function () {
    this.url = this.source;
  },
};
</script>

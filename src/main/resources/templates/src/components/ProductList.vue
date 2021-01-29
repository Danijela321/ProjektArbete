<template>
  <div id="productList">
    <div v-for="source in sources" :key="source">
      <product v-bind:source="source" />
    </div>
  </div>
</template>
<script>
import Product from "./Product.vue";
export default {
  data() {
    return {
      sources: [
        "/src/assets/images/bmwx1.jpg",
        "/src/assets/images/volvov70.jpg",
        "/src/assets/images/placeholder.png",
        "/src/assets/images/bmwx1.jpg",
        "/src/assets/images/volvov70.jpg",
        "/src/assets/images/placeholder.png",
      ],
    };
  },

  components: {
    Product,
  },

  methods: {},
};
</script>

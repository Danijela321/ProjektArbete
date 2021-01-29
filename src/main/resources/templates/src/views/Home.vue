<template>
  <div id="home">
    <Slideshow />
    <Sidebar />
    <div id="store">
      <ProductList />
    </div>
  </div>
</template>
<script>
import Sidebar from "../components/Sidebar.vue";
import ProductList from "../components/ProductList.vue";
import Slideshow from "../components/Slideshow.vue";

export default {
  components: {
    Sidebar,
    ProductList,
    Slideshow,
  },
};
</script>

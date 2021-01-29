<template>
  <div id="app">
    <div id="anchor">
      <Header />
      <div id="main-wrapper">
        <main id="main">
          <router-view />
        </main>
      </div>
      <Footer />
      <div id="backdrop" @click="toggleSidebar" />
    </div>
  </div>
</template>

<script>
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";

export default {
  name: "App",
  components: {
    Header,
    Footer,
  },

  methods: {
    toggleSidebar() {
      document.getElementById("side-bar").classList.toggle("toggle");
      document.getElementById("store").classList.toggle("toggle");
      document.getElementById("backdrop").classList.toggle("toggle");
      var dropdowns = document.getElementsByClassName("dropdown-container");
      for (var i = 0; i < dropdowns.length; i++) {
        dropdowns[i].classList.toggle("toggle");
      }
      console.log("toggling active");
    },
  },
};
</script>

<style lang="scss">
@import "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css";
@import "./assets/css/index.scss";
</style>

<template>
  <header id="header">
    <router-link to="/">
      <button id="btn-store">
        <div id="logo">
          <span>Web Store</span>
        </div>
      </button>
    </router-link>
    <searchbar id="header-search-bar" />
    <router-link to="/login">
      <button id="btn-login">
        <span>Login</span>
      </button>
    </router-link>
    <router-link to="/register">
      <button id="btn-register">
        <span>Register</span>
      </button>
    </router-link>
  </header>
</template>

<script>
import Searchbar from "./Searchbar.vue";
export default {
  components: {
    Searchbar,
  },
};
</script>

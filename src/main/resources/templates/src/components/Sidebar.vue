<template>
  <div id="side-bar">
    <div id="side-bar-block">
      <button id="btn-menu" @click="toggleSidebar">
        <span class="fa fa-bars" aria-hidden="true" />
      </button>
    </div>
    <div id="side-bar-slide">
      <div
        class="dropdown-container"
        v-for="dropdown in dropdowns"
        :key="dropdown.id"
      >
        <dropdown
          :initialDropdownId="dropdown.id"
          :initialButtonId="dropdown.buttonId"
          :initialText="dropdown.text"
          :initialArrowId="dropdown.arrowId"
          class="dropdown-block"
        ></dropdown>
      </div>
    </div>
  </div>
</template>

<script>
import Dropdown from "./Dropdown.vue";

export default {
  data() {
    return {
      dropdowns: [
        {
          id: "dropdown-brand",
          buttonId: "brand",
          arrowId: "arrowBrand",
          text: "Brand",
        },
        {
          id: "dropdown-model",
          buttonId: "model",
          arrowId: "arrowModel",
          text: "Model",
        },
        {
          id: "dropdown-price",
          buttonId: "price",
          arrowId: "arrowPrice",
          text: "Price",
        },
      ],
    };
  },
  components: {
    Dropdown,
  },
  methods: {
    toggleSidebar() {
      document.getElementById("side-bar").classList.toggle("toggle");
      document.getElementById("store").classList.toggle("toggle");
      document.getElementById("backdrop").classList.toggle("toggle");
      this.toggleElements("dropdown-container");
      console.log("toggling active");
    },

    toggleElements(element) {
      var elements = document.getElementsByClassName(element);
      for (var i = 0; i < elements.length; i++) {
        elements[i].classList.toggle("toggle");
      }
    },
  },
};
</script>

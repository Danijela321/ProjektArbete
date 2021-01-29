<template>
  <div class="dropdown-block">
    <button :id="buttonId" class="btn-dropdown" @click="toggleDropdown">
      <span>{{ text }}</span>
      <div
        :id="arrowId"
        class="arrow fa fa-arrow-down"
        aria-hidden="true"
      ></div>
    </button>
    <div :id="dropdownId" class="dropdown">
      <div class="checkbox-container">
        <ul>
          <li>
            <input type="checkbox" class="checkbox" id="car" value="car" />
            <label for="car">Example Text</label>
          </li>
          <li>
            <input type="checkbox" class="checkbox" id="model" value="car" />
            <label for="model">Example Text</label>
          </li>
          <li>
            <input type="checkbox" class="checkbox" id="type" value="car" />
            <label for="type">Example Text</label>
          </li>
          <li>
            <input type="checkbox" class="checkbox" id="etc" value="car" />
            <label for="etc">Example Text</label>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      text: this.initialText,
      dropdownId: this.initialDropdownId,
      buttonId: this.initialButtonId,
      arrowId: this.initialArrowId,
    };
  },

  props: {
    initialText: {
      type: String,
      default: "Text",
    },
    initialDropdownId: {
      type: String,
      default: "Dropdown",
    },
    initialButtonId: {
      type: String,
      default: "Button",
    },
    initialArrowId: {
      type: String,
      default: "Arrow",
    },
  },
  methods: {
    toggleDropdown() {
      document.getElementById(this.dropdownId).classList.toggle("toggle");
      document.getElementById(this.arrowId).classList.toggle("toggle");
    },
  },
};
</script>

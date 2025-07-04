<template>
  <v-app-bar :elevation="2">
    <template v-slot:prepend>
      <v-app-bar-nav-icon></v-app-bar-nav-icon>
    </template>

    <v-app-bar-title>두둥실</v-app-bar-title>

    <template v-slot:append>
      <v-btn @click="$emit('login')">Login</v-btn>
    </template>

  </v-app-bar>
</template>

<script setup>

</script>

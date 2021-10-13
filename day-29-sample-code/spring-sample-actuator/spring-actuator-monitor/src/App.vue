<template>
  <v-app id="app">
    <!--
    <img src="./assets/logo.png">
    -->
    <drawer></drawer>
    <!--
    <router-view/>
    -->
      <v-footer padless>
        <v-col
          class="text-center"
          cols="12"
        >
          Copyright © 2021/10  — <strong>Darius Weisting</strong>
        </v-col>
    </v-footer>
  </v-app>
</template>

<script>
import Drawer from '@/components/dashboard/Drawer'
export default {
  name: 'App',
  components: {
    Drawer
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>

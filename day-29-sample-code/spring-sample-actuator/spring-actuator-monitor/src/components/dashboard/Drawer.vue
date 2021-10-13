<template>
    <div id="dashboard">
        <v-app >
            <v-navigation-drawer
                style="height:100%;"
                enable-resize-watcher app dark
                src="https://cdn.vuetifyjs.com/images/backgrounds/bg-2.jpg"
                permanent
                expand-on-hover
            >
                <v-list>
                    <v-list-item class="px-2">
                        <v-list-item-avatar>
                        <v-img src="https://i.postimg.cc/sXzgxFgn/5-F27-C3-DC-4-F48-4-CF3-BC24-37-E70302-D679.jpg"></v-img>
                        </v-list-item-avatar>
                    </v-list-item>

                    <v-list-item link>
                        <v-list-item-content>
                        <v-list-item-title class="text-h6">
                            Weisting
                        </v-list-item-title>
                        <v-list-item-subtitle>showwei0217@gmail.com</v-list-item-subtitle>
                        </v-list-item-content>
                    </v-list-item>
                </v-list>

                <v-divider></v-divider>

                <v-list
                nav
                dense
                v-if="!isLoading"
                >
                    <v-list-item link to="/" v-if="actuatorServiceList.some((point) => point.name === 'info')">
                        <v-list-item-icon>
                        <v-icon>mdi-earth</v-icon>
                        </v-list-item-icon>
                        <v-list-item-title>Info</v-list-item-title>
                    </v-list-item>
                    <v-list-item link to="/memory" v-if="actuatorServiceList.some((point) => point.name === 'memory')">
                        <v-list-item-icon>
                        <v-icon>mdi-ruler</v-icon>
                        </v-list-item-icon>
                        <v-list-item-title  >Memory</v-list-item-title>
                    </v-list-item>
                    <v-list-item link to="/beans" v-if="actuatorServiceList.some((point) => point.name === 'beans')">
                        <v-list-item-icon>
                        <v-icon>mdi-saw-blade</v-icon>
                        </v-list-item-icon>
                        <v-list-item-title>Beans</v-list-item-title>
                    </v-list-item>
                    <v-list-item link to="/health" v-if="actuatorServiceList.some((point) => point.name === 'health')">
                        <v-list-item-icon>
                        <v-icon>mdi-book-cross</v-icon>
                        </v-list-item-icon>
                        <v-list-item-title>Health</v-list-item-title>
                    </v-list-item>
                    <!--
                    <v-list-item link v-if="actuatorServiceList.some((point) => point.name === 'conditions')">
                        <v-list-item-icon>
                        <v-icon>mdi-math-integral-box</v-icon>
                        </v-list-item-icon>
                        <v-list-item-title>Conditions</v-list-item-title>
                    </v-list-item>
                    <v-list-item link v-if="actuatorServiceList.some((point) => point.name === 'configprops')">
                        <v-list-item-icon>
                        <v-icon>mdi-chart-donut-variant</v-icon>
                        </v-list-item-icon>
                        <v-list-item-title>Configprops</v-list-item-title>
                    </v-list-item>
                    -->
                    <v-list-item  to="/environment" link v-if="actuatorServiceList.some((point) => point.name === 'env')">
                        <v-list-item-icon>
                        <v-icon>mdi-weather-partly-cloudy</v-icon>
                        </v-list-item-icon>
                        <v-list-item-title>Environment</v-list-item-title>
                    </v-list-item>
                    <v-list-item  to="/metrics" link v-if="actuatorServiceList.some((point) => point.name === 'metrics')">
                        <v-list-item-icon>
                        <v-icon>mdi-map-marker-multiple</v-icon>
                        </v-list-item-icon>
                        <v-list-item-title>Metrics</v-list-item-title>
                    </v-list-item>
                    <v-list-item link to="/scheduled" v-if="actuatorServiceList.some((point) => point.name === 'scheduledtasks')">
                        <v-list-item-icon>
                        <v-icon>mdi-alarm-multiple</v-icon>
                        </v-list-item-icon>
                        <v-list-item-title>Scheduled Tasks</v-list-item-title>
                    </v-list-item>
                    
                </v-list>
            </v-navigation-drawer>

            <v-content>
                <v-container fluid>
                    <router-view></router-view>
                </v-container>
            </v-content>
            
        </v-app>
    </div>
</template>

<script>

import {getActuator} from '@/assets/js/api/actuator.js'
export default {
  name: 'Dashboard',
  data () {
    return {
      items: [
        ['mdi-email', 'Inbox'],
        ['mdi-account-supervisor-circle', 'Supervisors'],
        ['mdi-clock-start', 'Clock-in']
      ],
      actuatorServiceList: [],
      isLoading: false
    }
  },
  methods: {
    listActuator () {
      this.isLoading = true;
      getActuator().then((response) => {
        Object.keys(response.data._links).forEach(key => {
          this.actuatorServiceList.push({'name':key,'href':response.data._links[key].href});
        })
        this.isLoading = false;
      })
        .catch((error) => {
          console.log(error);
        })
    }
  },
  mounted() {
    this.listActuator();
  }
}
</script>

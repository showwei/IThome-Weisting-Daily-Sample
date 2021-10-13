<template>
    <div id="info" class="row">
        <v-app dark style="width:100%">
            <v-container grid-list-md text-xs-center fluid>
                <v-layout row wrap >
                    <v-row justify="space-around" >
                        <v-card width="100%">
                            <v-img
                            height="200px"
                            src="https://miro.medium.com/max/1400/1*XiML5rUROwZ76MyHYONTSg.png"
                            >
                                <v-card-title class="amber--text mt-6">
                                    <v-avatar size="56">
                                    <img
                                        alt="user"
                                        src="https://www.logolynx.com/images/logolynx/d0/d0c486f981d3120338b692278298484a.jpeg"
                                    >
                                    </v-avatar>
                                    <p class="ml-3  blue--text text--lighten-5" v-if ="informationMonitor.app">
                                        {{ informationMonitor.app.name}}
                                    </p>

                                </v-card-title>
                                <v-card-title class="white--text" v-if ="informationMonitor.app">
                                        <p class="ml-3">{{ informationMonitor.app.description }}</p> 
                                </v-card-title>
                            </v-img>

                            <v-card-text>
                            <div class="font-weight-bold ml-8 mb-2">
                                Service Information
                            </div>

                            <v-timeline
                                align-top
                                dense
                            >
                                <v-timeline-item
                                v-for="(value,key,i) in informationMonitor.app"
                                :key="key"
                                :color="colors[i % 2]"
                                v-if = "key !== 'name' && key !== 'description'"
                                small
                                >
                                <div>
                                    <div class="font-weight-normal">
                                    <strong>{{ key.replace('_',' ').toUpperCase() }}</strong> 
                                    </div>
                                    <div>{{value }}</div>
                                </div>
                                </v-timeline-item>
                            </v-timeline>
                            </v-card-text>
                        </v-card>
                    </v-row>
               </v-layout>
            </v-container>
        </v-app>
    </div>
</template>
<script>
import { getServiceInformation } from '@/assets/js/api/actuator'
export default {
    name: 'InfoPage',
    data () {
        return {
            informationMonitor: {},
            colors: ['deep-purple lighten-1','green']
        }
    },
    methods: {
        getServiceInformation() {
            getServiceInformation().then((response) => {
                this.informationMonitor = response.data;
            })
              .catch((error) => {
                  console.log(error);
              })
        }
    },
    mounted() {
        this.getServiceInformation();
    }
}
</script>
<style scoped>
#info {
  margin-top: 0 px;
  padding-left: 5px;
}

</style>


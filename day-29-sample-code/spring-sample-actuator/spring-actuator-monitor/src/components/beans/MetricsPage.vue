<template>
    <div id="metrics" class="row">
        <v-app dark style="width:100%;height:80%;">
            <v-container grid-list-md text-xs-center fluid >
                <v-layout row wrap >
                    <v-row justify="space-around" >
                        <v-card width="100%">
                            <v-img
                            height="200px"
                            src="https://miro.medium.com/max/1400/1*XiML5rUROwZ76MyHYONTSg.png"
                            >
                                <v-card-title class="amber--text mt-8">
                                    <v-avatar size="56">
                                    <img
                                        alt="user"
                                        src="https://www.logolynx.com/images/logolynx/d0/d0c486f981d3120338b692278298484a.jpeg"
                                    >
                                    </v-avatar>
                                    <p class="ml-3 blue--text text--lighten-5"  v-if="informationMonitor.app">
                                        {{ informationMonitor.app.name}}
                                    </p>

                                </v-card-title>

                            </v-img>
                            <v-card-text>
                                <div class="font-weight-bold ml-8 mb-2">
                                    Metrics service information
                                </div>
                            </v-card-text>
                        </v-card>
                    </v-row>
                </v-layout>
                <v-tabs
                    color="deep-purple accent-4"
                    right
                    v-if="serviceMetrics.names"
                >

                    <v-tab 
                        v-for="(item, index) in serviceMetrics.names"
                        :key="item"
                    >
                        {{ item }}
                    </v-tab>

                    <v-tab-item
                        v-for="(item, i) in serviceMetrics.names"
                        :key="i"
                    >
                        <v-container fluid>
                            <MetricsDetail :metricName="item"  style="padding-top:15px;">
                            </MetricsDetail>
                        </v-container>
                    </v-tab-item>
                </v-tabs>
            </v-container>
            
        </v-app>
    </div>
</template>
<script>
import { 
        getServiceMetrics,
        getServiceInformation
       } from '@/assets/js/api/actuator'

import MetricsDetail from '@/components/sub_components/MetricsDetails'
export default {
    name: 'MetricsPage',
    data () {
        return {
            serviceMetrics: {},
            informationMonitor: {}
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
        },
        getServiceMetrics() {
            getServiceMetrics().then((response) => {
                this.serviceMetrics = response.data;
            })
              .catch((error) => {
                  console.log(error);
              })
        }
    },
    mounted() {

        this.getServiceInformation();
        this.getServiceMetrics();
    },components: {
        MetricsDetail
    }
}

</script>
<style scoped>
#metrics {
  margin-top: 0 px;
  padding-left: 5px;
}

</style>

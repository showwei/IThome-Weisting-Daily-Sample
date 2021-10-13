<template>
    <div id="metrics" class="row">
        
        <v-row>
            <v-col
                 cols="12"
                 sm="4">
                <v-card
                    class="mx-auto"
                    outlined
                    shaped
                    v-if ="metricsMonitorDetail.baseUnit"
                >
                    <v-list-item three-line>
                        <v-list-item-avatar
                            tile
                            size="80"
                            style="width:20%;"
                        >
                            <v-icon style="font-size:80px;">mdi-midi-port</v-icon>
                        </v-list-item-avatar>
                        <v-list-item-content 
                            style="width:80%;">
                            <div class="text-overline mb-4">
                                BASEUNIT
                            </div>
                            <v-list-item-title class="text-h5 mb-1">
                                {{ metricsMonitorDetail.baseUnit }}
                            </v-list-item-title>
                            <v-card-text v-if="metricsMonitorDetail.description">
                                {{ metricsMonitorDetail.description }}
                            </v-card-text>
                            <v-list-item-subtitle v-if="metricsMonitorDetail.measurements">
                                <span v-for="(item,index) in metricsMonitorDetail.measurements">
                                    <v-list-item-content>
                                        <v-list-item-title v-text="item.statistic"></v-list-item-title>
                                        <v-list-item-subtitle >{{ item.value }}</v-list-item-subtitle>
                                    </v-list-item-content>
                                </span>
                            </v-list-item-subtitle>
                        </v-list-item-content>
                    </v-list-item>
                </v-card>
            </v-col>
            <v-col
                cols="12"
                sm="4"
                v-if ="metricsMonitorDetail.availableTags"
                v-for="(item,index) in metricsMonitorDetail.availableTags" 
                :key="item.tag"
            >
                <v-card
                    class="mx-auto"
                    outlined
                    shaped
                >
                    <v-list-item three-line>
                        <v-list-item-avatar
                            tile
                            size="80"
                            style="width:20%;"
                        >
                            <v-icon style="font-size:80px;">mdi-midi-port</v-icon>
                        </v-list-item-avatar>
                        <v-list-item-content 
                            style="width:80%;">
                            <div class="text-overline mb-4">
                                {{ item.tag }}
                            </div>
                            <v-list-item-title class="text-h5 mb-1" v-if = "item.values.length == 1">
                                <v-card-text >
                                    {{ item.values[0] }}
                                </v-card-text>
                            </v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                    <v-list>
                        <v-list-group
                            no-action
                            sub-group
                            v-if="item.values.length > 1"
                        >
                            <template v-slot:activator>
                                <v-list-item-content>
                                    <v-list-item-title> {{ item.tag.toUpperCase() }} LIST</v-list-item-title>
                                </v-list-item-content>
                            </template>
                            <v-list-item
                                v-for="(tagValue) in item.values"
                                :key="tagValue"
                                link
                                two-line
                            >
                                <v-list-item-icon>
                                    <v-icon >mdi-sprout</v-icon>
                                </v-list-item-icon>
                                <v-list-item-content>
                                    <v-card-text > {{ tagValue }}</v-card-text>
                                </v-list-item-content>
                                
                            </v-list-item>
                        </v-list-group>
                     </v-list>
                </v-card>
            </v-col>
        </v-row>
    </div>
</template>

<script>

import { getServiceMetricsByName } from '@/assets/js/api/actuator'
export default {
    name: 'MetricsDetail',
    data () {
        return {
            metricsMonitorDetail: {},
            length: 3,
            window: 0
        }
    },
    methods: {
        getServiceMetricsByName() {
             getServiceMetricsByName(this.metricName).then((response) => {
                this.metricsMonitorDetail = response.data;
                console.log(response.data);
            })
              .catch((error) => {
                  console.log(error);
              })
        }
    },
    props: {
        metricName: {
            type: String,
            required: true
        }
    },
    mounted() {
        this.getServiceMetricsByName();
    }

}
</script>

<style scoped>
#metrics {
  margin-top: 0 px;
  padding-left: 5px;
}

</style>
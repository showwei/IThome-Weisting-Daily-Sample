<template>
    <div id="info" class="row">
        <v-app dark style="width:100%;height:80%;">
            <v-container grid-list-md text-xs-center fluid 
                v-if = "!isLoading">
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
                                    Service Status
                                </div>
                                <v-container class="grey lighten-5">
                                    <v-row no-gutters>
                                        <v-col
                                            cols="12"
                                            sm="4"
                                        >
                                            <v-card
                                                class="mx-auto"
                                                max-width="344"
                                            >
                                                <v-img 
                                                    v-if="healthMonitor &&healthMonitor.status"
                                                    src="https://i.pinimg.com/originals/35/f3/23/35f323bc5b41dc4269001529e3ff1278.gif"
                                                    height="200px"
                                                ></v-img>
                                                <v-img 
                                                    v-if="healthMonitor && !healthMonitor.status"
                                                    src="https://thumbs.gfycat.com/OldfashionedVigorousGalah-size_restricted.gif"
                                                    height="200px"
                                                ></v-img>
                                                <v-card-title>
                                                    Service STATUS
                                                </v-card-title>

                                                <v-card-subtitle v-if="informationMonitor.app">
                                                    {{ informationMonitor.app.name}}
                                                </v-card-subtitle>
                                                <v-card-actions>
                                                    <v-btn
                                                        color="orange lighten-2"
                                                        text
                                                    >
                                                        Explore
                                                    </v-btn>

                                                    <v-spacer></v-spacer>

                                                    <v-btn
                                                        icon
                                                        @click="serviceShow = !serviceShow"
                                                    >
                                                        <v-icon>{{ serviceShow ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
                                                    </v-btn>
                                                </v-card-actions>

                                                <v-expand-transition  v-if="informationMonitor.java">
                                                    <div v-show="serviceShow">
                                                        <v-divider></v-divider>

                                                        
                                                        <v-list-item two-line>
                                                            <v-list-item-content>
                                                                <v-list-item-title>Java vendor</v-list-item-title>
                                                                <v-list-item-subtitle>{{ informationMonitor.java.vendor }}</v-list-item-subtitle>
                                                            </v-list-item-content>
                                                        </v-list-item>
                                                        <v-list-item two-line>
                                                            <v-list-item-content>
                                                                <v-list-item-title>Java version</v-list-item-title>
                                                                <v-list-item-subtitle>{{ informationMonitor.java.version }}</v-list-item-subtitle>
                                                            </v-list-item-content>
                                                        </v-list-item>
                                                        <v-list-item two-line>
                                                            <v-list-item-content>
                                                                <v-list-item-title>Java name</v-list-item-title>
                                                                <v-list-item-subtitle>{{ informationMonitor.java.name }}</v-list-item-subtitle>
                                                            </v-list-item-content>
                                                        </v-list-item>
                                                        <v-list-item two-line>
                                                            <v-list-item-content>
                                                                <v-list-item-title>Java version date </v-list-item-title>
                                                                <v-list-item-subtitle>{{ informationMonitor.java.version_date }}</v-list-item-subtitle>
                                                            </v-list-item-content>
                                                        </v-list-item>
                                                        <v-list-item two-line>
                                                            <v-list-item-content>
                                                                <v-list-item-title>Java runtime name </v-list-item-title>
                                                                <v-list-item-subtitle>{{ informationMonitor.java.runtime_name }}</v-list-item-subtitle>
                                                            </v-list-item-content>
                                                        </v-list-item> 
                                                        <v-list-item two-line>
                                                            <v-list-item-content>
                                                                <v-list-item-title>Java runtime class version </v-list-item-title>
                                                                <v-list-item-subtitle>{{ informationMonitor.java.runtime_class_verion }}</v-list-item-subtitle>
                                                            </v-list-item-content>
                                                        </v-list-item>
                                                        <v-list-item two-line>
                                                            <v-list-item-content>
                                                                <v-list-item-title>Java vm information </v-list-item-title>
                                                                <v-list-item-subtitle>{{ informationMonitor.java.vm_info }}</v-list-item-subtitle>
                                                            </v-list-item-content>
                                                        </v-list-item>
                                                    </div>
                                                </v-expand-transition>
                                            </v-card>
                                        </v-col>
                                        <v-col
                                            cols="12"
                                            sm="4"
                                        >
                                            <v-card
                                                class="mx-auto"
                                                max-width="344"
                                            >
                                                <v-img 
                                                    v-if="healthMonitor.components && healthMonitor.components.diskSpace.status"
                                                    src="https://i.pinimg.com/originals/35/f3/23/35f323bc5b41dc4269001529e3ff1278.gif"
                                                    height="200px"
                                                ></v-img>
                                                <v-img 
                                                    v-if="healthMonitor.components && !healthMonitor.components.diskSpace.status"
                                                    src="https://thumbs.gfycat.com/OldfashionedVigorousGalah-size_restricted.gif"
                                                    height="200px"
                                                ></v-img>

                                                <v-card-title>
                                                    Disk STATUS
                                                </v-card-title>

                                                <v-card-subtitle>
                                                    Machine Hardware Disk status
                                                </v-card-subtitle>

                                                <v-card-actions>
                                                    <v-btn
                                                        color="orange lighten-2"
                                                        text
                                                    >
                                                        Explore
                                                    </v-btn>

                                                    <v-spacer></v-spacer>

                                                    <v-btn
                                                        icon
                                                        @click="diskShow = !diskShow"
                                                    >
                                                        <v-icon>{{ diskShow ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
                                                    </v-btn>
                                                </v-card-actions>

                                                <v-expand-transition>
                                                    <div v-show="diskShow" v-if="healthMonitor.components">
                                                        <v-divider></v-divider>

                                                        
                                                        <v-list-item three-line>
                                                            <v-list-item-content>
                                                                <v-list-item-title>Total Memory</v-list-item-title>
                                                                <v-list-item-subtitle>{{ healthMonitor.components.diskSpace.details.total }}</v-list-item-subtitle>
                                                                <v-list-item-subtitle>bytes</v-list-item-subtitle>
                                                            </v-list-item-content>
                                                        </v-list-item>
                                                        <v-list-item three-line>
                                                            <v-list-item-content>
                                                                <v-list-item-title>Free Memory</v-list-item-title>
                                                                <v-list-item-subtitle>{{ healthMonitor.components.diskSpace.details.free }}</v-list-item-subtitle>
                                                                <v-list-item-subtitle>bytes</v-list-item-subtitle>
                                                            </v-list-item-content>
                                                        </v-list-item>
                                                        <v-list-item three-line>
                                                            <v-list-item-content>
                                                                <v-list-item-title>Threshold Memory</v-list-item-title>
                                                                <v-list-item-subtitle>{{ healthMonitor.components.diskSpace.details.threshold }}</v-list-item-subtitle>
                                                                <v-list-item-subtitle>bytes</v-list-item-subtitle>
                                                                
                                                            </v-list-item-content>
                                                        </v-list-item>
                                                        <v-list-item two-line>
                                                            <v-list-item-content>
                                                                <v-list-item-title>Exist </v-list-item-title>
                                                                <v-list-item-subtitle>{{ healthMonitor.components.diskSpace.details.exists ? "WORKING" : "FAIL." }}</v-list-item-subtitle>
                                                            </v-list-item-content>
                                                        </v-list-item>
                                                            
                                                            
                                                    </div>
                                                </v-expand-transition>
                                            </v-card>
                                        </v-col>
                                        <v-col
                                            cols="12"
                                            sm="4"
                                        >
                                            <v-card
                                                class="mx-auto"
                                                max-width="344"
                                                v-if="healthMonitor.components"
                                            >
                                                <v-img 
                                                    v-if="healthMonitor.components.ping.status"
                                                    src="https://i.pinimg.com/originals/35/f3/23/35f323bc5b41dc4269001529e3ff1278.gif"
                                                    height="200px"
                                                ></v-img>

                                                <v-img 
                                                    v-if="!healthMonitor.components.ping.status"
                                                    src="https://thumbs.gfycat.com/OldfashionedVigorousGalah-size_restricted.gif"
                                                    height="200px"
                                                ></v-img>
                                                <v-card-title>
                                                    Ping STATUS
                                                </v-card-title>

                                                <v-card-subtitle>
                                                    Webservice ping status
                                                </v-card-subtitle>

                                            </v-card>
                                        </v-col>
                                    </v-row>
                                </v-container>
                            </v-card-text>
                        </v-card>
                    </v-row>

               </v-layout>
               
            </v-container>
        </v-app>
    </div>
</template>
<script>
import { 
        getServiceHealth,
        getServiceInformation
       } from '@/assets/js/api/actuator'
export default {
    name: 'HealthPage',
    data () {
        return {
            healthMonitor: {},
            informationMonitor: {},
            diskShow: false,
            serviceShow : false,
            isLoading: false,
            color: '#42A5F5',  
        }
    },
    methods: {
        getServiceHealth() {
            this.isLoading = true;
            getServiceHealth().then((response) => {
                this.healthMonitor = response.data;
                this.isLoading = false;
            })
              .catch((error) => {
                  console.log(error);
              })
        },
        getServiceInformation() {
            this.isLoading=true;
            getServiceInformation().then((response) => {
                this.informationMonitor = response.data;
                this.isLoading = false;
            })
              .catch((error) => {
                  console.log(error);
              })
        }
    },
    mounted() {
        this.getServiceHealth();
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


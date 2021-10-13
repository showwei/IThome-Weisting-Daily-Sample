<template>
    <div id="env" class="row">
        <v-app dark style="width:100%">
            <v-container grid-list-md text-xs-center fluid>
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
                                    <p class="ml-3 blue--text text--lighten-5" v-if="informationMonitor && informationMonitor.app" >
                                        {{ informationMonitor.app.name}}
                                    </p>

                                </v-card-title>
                            </v-img>
                                 <div class="font-weight-bold ml-8 mb-2">
                                    Environment Setting
                                </div>
                                <v-row>
                                    <v-col
                                            v-for="(item,key ) in systemProperties.properties"
                                            :key="key"
                                            v-if="!ignoreProperties.includes(key)"
                                            cols="12"
                                            sm="3"
                                            style="height:200px"
                                        >
                                            <v-card
                                                dark
                                                style="height:100%"
                                            >
                                                <div class="d-flex flex-no-wrap justify-space-between">
                                                    <div  style="width:78%;">
                                                        <v-card-title >
                                                            <v-icon>mdi-crosshairs-gps</v-icon><font style="font-size:13px;">&nbsp;  {{ key }}</font>
                                                        </v-card-title>    

                                                        <v-card-text v-if="item.value.length < 10" >
                                                            <font style="font-size:30px">
                                                                {{ item.value.toUpperCase() }}
                                                            </font>
                                                        </v-card-text>
                                                        <v-card-text v-if="item.value.length >= 10 && item.value.length < 20" >
                                                            <font style="font-size:22px">
                                                                {{ item.value.toUpperCase() }}
                                                            </font>
                                                        </v-card-text>
                                                        <v-card-text v-if="item.value.length >= 20 && item.value.length <= 30" >
                                                            <font style="font-size:18px">
                                                                {{ item.value.toUpperCase() }}
                                                            </font>
                                                        </v-card-text>
                                                        <v-card-text v-if="item.value.length > 30">
                                                            <font style="font-size:10px">
                                                                {{ item.value }}
                                                            </font>
                                                        </v-card-text>
                                                    </div>

                                                    <v-avatar
                                                        class="ma-3"
                                                        size="60"
                                                        tile
                                                        style="width:22%;"
                                                    >
                                                        <v-icon style="font-size:80px;">mdi-language-java</v-icon>
                                                    </v-avatar>
                                                </div>
                                            </v-card>
                                    </v-col>
                                </v-row>
                        </v-card>
                    </v-row>
                </v-layout>
            </v-container>
        </v-app >
    </div>
</template>

<script>
import { getServiceInformation ,getServiceEnvironment} from '@/assets/js/api/actuator'
export default {
    name: 'EnvironmentPage',
    data () {
        return {
            informationMonitor: {},
            systemProperties: {},
            colors: ['deep-purple lighten-1','green'],
            ignoreProperties: ['http.nonProxyHosts','java.class.path']
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
        getServiceEnvironment() {
            getServiceEnvironment().then((response) => {
                this.systemProperties = response.data.propertySources.find( propertyObj => propertyObj.name === 'systemProperties');
                console.log(this.systemProperties);
            })
              .catch((error) => {
                  console.log(error);
              })
        }
    },
    mounted() {
        this.getServiceInformation();
        this.getServiceEnvironment();
    }
}
</script>
<style scoped>
#env {
  margin-top: 0 px;
  padding-left: 3px;
}

</style>

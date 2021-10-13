<template>
    <div id="memory" class="row">
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
                                        <p class="ml-3  blue--text text--lighten-5">
                                            Sea food Runtime Usage
                                        </p>
                                    </v-card-title>
                                </v-img>

                                <v-card-text>
                                    <div class="font-weight-bold ml-8 mb-2">
                                       The Java SE Runtime Environment contains the Java virtual machine, runtime class libraries, and Java application launcher that are necessary to run programs written in the Java programming language. It is not a development environment and does not contain development tools such as compilers or debuggers. For development tools, see the Java SE Development Kit (JDK(TM)).
                                    </div>
                                </v-card-text>
                                <v-list three-line style="width:50%">
                                    <v-list-item
                                        v-for="(value, key) in memoryMonitor"
                                        :key="key"
                                        ripple
                                    >
                                        <v-chip
                                            class="mr-2"
                                        >
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <v-icon
                                                large
                                                color="blue darken-2"
                                            >
                                                mdi-nut
                                            </v-icon>
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {{ key.toUpperCase() }} &nbsp;&nbsp;&nbsp;
                                        </v-chip>
                                        <v-list-item-content>
                                            <v-list-item-title v-text="value"></v-list-item-title>
                                            <v-list-item-subtitle v-if="key !== 'available-processors'">bytes</v-list-item-subtitle>

                                            <v-list-item-subtitle v-else> cores</v-list-item-subtitle>
                                        </v-list-item-content>
                                        
                                    </v-list-item>
                                </v-list>
                        </v-card>
                   </v-row>
               </v-layout>
                
            </v-container>
        </v-app>
    </div>
</template>
<script>
import { getServiceMemoryUsage } from '@/assets/js/api/actuator'
export default {
    name: 'MemoryPage',
    data () {
        return {
            memoryMonitor: {}
        }
    },
    methods: {
        getServiceMemoryUsage() {
            getServiceMemoryUsage().then((response) => {
                this.memoryMonitor = response.data;
            })
              .catch((error) => {
                  console.log(error);
              })
        }
    },
    mounted() {
        this.getServiceMemoryUsage();
    }
}
</script>

<style scoped>
#info {
  margin-top: 0 px;
  padding-left: 5px;
}

</style>


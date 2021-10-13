<template>
    <div id="info" class="row">
        <v-app dark style="width:100%">
            <v-container grid-list-md text-xs-center fluid>
                <v-layout row wrap >
                    <v-row justify="space-around" >
                        <v-card
                            class="mx-auto"
                            width="100%"
                        >
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
                                    <p class="ml-3 blue--text text--lighten-5" v-if="informationMonitor && informationMonitor.app" >
                                        {{ informationMonitor.app.name}}
                                    </p>

                                </v-card-title>
                                <v-card-title class="white--text" v-if="informationMonitor && informationMonitor.app">
                                        <p class="ml-3">{{ informationMonitor.app.description }}</p> 
                                </v-card-title>
                            </v-img>
                            <v-card-text>
                                <div class="font-weight-bold ml-8 mb-2">
                                    Scheduled Setting
                                </div>

                                <v-list>
                                    <v-list-group
                                        :value="true"
                                        no-action
                                        sub-group
                                        v-if="scheduledMonitor.cron"
                                    >
                                        <template v-slot:activator>
                                            <v-list-item-content>
                                            <v-list-item-title>Cron Jobs</v-list-item-title>
                                            </v-list-item-content>
                                        </template>

                                        <v-list-item
                                            v-for="(item) in scheduledMonitor.cron"
                                            :key="item.runnable.target"
                                            link
                                            two-line
                                        >
                                            <v-list-item-content>
                                                <v-list-item-title v-text="item.runnable.target"></v-list-item-title>
                                                <v-list-item-subtitle >Expression : {{ item.expression }}</v-list-item-subtitle>
                                            </v-list-item-content>
                                            <v-list-item-icon>
                                                <v-icon >mdi-timeline-clock-outline</v-icon>
                                            </v-list-item-icon>
                                        </v-list-item>
                                    </v-list-group>

                                    <v-list-group
                                        :value="true"
                                        no-action
                                        sub-group
                                    >
                                        <template v-slot:activator>
                                            <v-list-item-content>
                                                <v-list-item-title>Fixed Delay Jobs</v-list-item-title>
                                            </v-list-item-content>
                                        </template>
                                        <v-list-item
                                            v-for="(item) in scheduledMonitor.fixedDelay"
                                            :key="item.runnable.target"
                                            link
                                            three-line
                                        >
                                            <v-list-item-content>
                                                <v-list-item-title v-text="item.runnable.target"></v-list-item-title>
                                                <v-list-item-subtitle >InitialDelay : {{ item.initialDelay }}</v-list-item-subtitle>
                                                <v-list-item-subtitle >Interval : {{ item.interval }}</v-list-item-subtitle>
                                            </v-list-item-content>
                                            <v-list-item-icon>
                                                <v-icon>mdi-alarm-plus</v-icon>
                                            </v-list-item-icon>
                                        </v-list-item>
                                    </v-list-group>
                                    <v-list-group
                                        :value="true"
                                        no-action
                                        sub-group
                                    >
                                        <template v-slot:activator>
                                            <v-list-item-content>
                                            <v-list-item-title>Fixed Rate Jobs</v-list-item-title>
                                            </v-list-item-content>
                                        </template>
                                       <v-list-item
                                            v-for="(item) in scheduledMonitor.fixedRate"
                                            :key="item.runnable.target"
                                            link
                                            three-line
                                        >
                                            <v-list-item-content>
                                                <v-list-item-title v-text="item.runnable.target"></v-list-item-title>
                                                <v-list-item-subtitle >InitialDelay : {{ item.initialDelay }}</v-list-item-subtitle>
                                                <v-list-item-subtitle >Interval : {{ item.interval }}</v-list-item-subtitle>
                                            </v-list-item-content>
                                            <v-list-item-icon>
                                                <v-icon>mdi-clock-start</v-icon>
                                            </v-list-item-icon>
                                        </v-list-item>
                                    </v-list-group>
                                </v-list>
                            </v-card-text>
                        </v-card>
                    </v-row>
               </v-layout>
            </v-container>
        </v-app>
    </div>
</template>
<script>
import { getServiceSchedulers,getServiceInformation } from '@/assets/js/api/actuator'
export default {
    name: 'ScheduledPage',
    data () {
        return {
            informationMonitor:{},
            scheduledMonitor: {},
            admins: [
                ['Management', 'mdi-account-multiple-outline'],
                ['Settings', 'mdi-cog-outline'],
            ],
            cruds: [
                ['Create', 'mdi-plus-outline'],
                ['Read', 'mdi-file-outline'],
                ['Update', 'mdi-update'],
                ['Delete', 'mdi-delete'],
            ],
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
        getServiceSchedulers() {
            getServiceSchedulers().then((response) => {
                this.scheduledMonitor = response.data;
            })
              .catch((error) => {
                  console.log(error);
              })
        }
    },
    mounted() {
        this.getServiceInformation();
        this.getServiceSchedulers();
    }
}
</script>
<style scoped>
#info {
  margin-top: 0 px;
  padding-left: 5px;
}

</style>


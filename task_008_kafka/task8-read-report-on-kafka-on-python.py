# python3

# running system script to read files through KAFKA
Author Jaime «July 15th»

if __name__ == '__main__':
	# run consumer
	import os

	def consume ():
		# launch_consumer='source .profile; source .bash_profile; kafka-console-consumer.sh --bootstrap-server localhost:9099 --topic kafkaTest'
		launch_consumer='source .profile; source .bash_profile; kafka-console-consumer.sh --bootstrap-server localhost:9099 --topic kafkaTest --from-beginning'
		os.system('ssh hadoop@namesync "{}"'.format(launch_consumer))

	def produce_as (stream):
		launch_producer='source .profile; source .bash_profile; kafka-console-producer.sh --broker-list localhost:9099 --topic kafkaTest'
		os.system('ssh hadoop@namesync "{}" <"{}"'.format(launch_producer,stream))

	consume()
	produce('./input.txt')

# Python 3

# read shakespeare's complete works,
#  count the instances of each word.

input_text = 'shakespeare.txt'
words = dict()
with open(input_text, 'r') as text:
	import re
	for group in re.split('[\W\0\r\d\s]+',text.read().lower()):
		words[group] = 1 + words.get(group,0)

output_text = 'output.txt'
with open(output_text, 'w') as text:
	for key in words:
		text.write('{:0=-70}, {}\n'.format(words[key],key))

